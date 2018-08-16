const entryBuild = require('../entry/entry.js');
let entry = {};
entryBuild.map((data) => {
    entry[data.name] = ['./entryBuild/' + data.name + '.js', data.title];
});
module.exports = entry;