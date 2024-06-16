module.exports = (sequelize, DataTypes) => {
    return sequelize.define('Solicitud', {
      ID: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
      CODIGO: { type: DataTypes.STRING },
      DESCRIPCION: { type: DataTypes.STRING },
      RESUMEN: { type: DataTypes.STRING },
      ID_EMPLEADO: { type: DataTypes.INTEGER },
    }, {
      tableName: 'SOLICITUD',
      timestamps: false
    });
  };
  