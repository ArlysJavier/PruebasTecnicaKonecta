const { Sequelize } = require('sequelize');
const sequelize = new Sequelize('BD_Pruebas', 'SYSTEM', 'mecatronica07*', {
  host: 'localhost',
  dialect: 'oracle',
});

const db = {};
db.Sequelize = Sequelize;
db.sequelize = sequelize;

db.Empleado = require('./empleado')(sequelize, Sequelize);
db.Solicitud = require('./solicitud')(sequelize, Sequelize);

db.Empleado.hasMany(db.Solicitud, { foreignKey: 'ID_EMPLEADO' });
db.Solicitud.belongsTo(db.Empleado, { foreignKey: 'ID_EMPLEADO' });

module.exports = db;
