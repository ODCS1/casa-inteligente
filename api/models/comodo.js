const database = require('../db');

const Comodo = database.sequelize.define('Comodos', {
    cod_comodo: {
        type: database.Sequelize.STRING(10),
        allowNull: false,
        primaryKey: true
    },
    nome_comodo: {
        type: database.Sequelize.STRING(25),
        allowNull: false,
        unique: true
    }
},
{
    timestamps: false
});

module.exports = Comodo;