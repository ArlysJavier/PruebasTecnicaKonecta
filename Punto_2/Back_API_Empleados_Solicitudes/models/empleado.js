module.exports = (sequelize, DataTypes) => {
    return sequelize.define('Empleado', {
      ID: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
      FECHA_INGRESO: { type: DataTypes.DATE },
      NOMBRE: { type: DataTypes.STRING },
      SALARIO: { type: DataTypes.FLOAT },
    }, {
      tableName: 'EMPLEADO',
      timestamps: false
    });
  };
  