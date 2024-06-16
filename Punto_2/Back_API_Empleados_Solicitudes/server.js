const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const db = require('./models');

const app = express();
const port = 5000;

app.use(cors());
app.use(bodyParser.json());

const authenticateToken = (req, res, next) => {
  const token = req.headers['authorization'];
  if (!token) return res.sendStatus(403);

  jwt.verify(token, 'your_jwt_secret', (err, user) => {
    if (err) return res.sendStatus(403);
    req.user = user;
    next();
  });
};

app.get('/empleados', authenticateToken, async (req, res) => {
  const empleados = await db.Empleado.findAll();
  res.json(empleados);
});

app.post('/empleados', authenticateToken, async (req, res) => {
  const nuevoEmpleado = await db.Empleado.create(req.body);
  res.status(201).json(nuevoEmpleado);
});

app.get('/solicitudes', authenticateToken, async (req, res) => {
  const solicitudes = await db.Solicitud.findAll({ include: db.Empleado });
  res.json(solicitudes);
});

app.post('/solicitudes', authenticateToken, async (req, res) => {
  const nuevaSolicitud = await db.Solicitud.create(req.body);
  res.status(201).json(nuevaSolicitud);
});

app.delete('/solicitudes/:id', authenticateToken, async (req, res) => {
  await db.Solicitud.destroy({ where: { ID: req.params.id } });
  res.sendStatus(204);
});

app.post('/login', async (req, res) => {
  const { username, password } = req.body;
  const token = jwt.sign({ username }, 'your_jwt_secret');
  res.json({ token });
});

db.sequelize.sync().then(() => {
  app.listen(port, () => {
    console.log(`Servidor corriendo en http://localhost:${port}`);
  });
});
