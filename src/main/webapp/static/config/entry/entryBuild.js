const fs = require("fs");
const path = require("path");
const entry = require('./entry');
const rimraf = require('rimraf');

//定义entryBuild
const entryBuildPath = path.resolve(__dirname, '../../entryBuild');

const componentBuildPath = path.resolve(__dirname, '../../app/component');

//删除entryBuild
rimraf.sync(entryBuildPath);

fs.mkdirSync(entryBuildPath);

const entryContent = data => `import React from 'react';
import ReactDOM from 'react-dom';
import Index from '../app/component/${data.path}';
import Header from '../app/component/common/head.jsx';
import Footer from '../app/component/common/foot.jsx';
ReactDOM.render([<Header key="Header"/>,<Index key="Index"/>,<Footer key="Footer"/>],document.getElementById('app'));`;


const jsxContent = data => `import React from 'react';
class Index extends React.Component {
    render() {
        return (
            <div className="cont">
                <div className="index">
                    ${data.description}
                </div>
            </div>
        );
    }
}
export default Index;`;


/*生成webpack entry 入口文件*/
entry.map((data) => {

    fs.writeFile(entryBuildPath + '/' + data.name + '.js', entryContent(data), 'utf8', function (err) {
        if (err) {
            return console.log('js:' + err);
        }
    });

    const jsxBuildPath = componentBuildPath + '/' + data.name;
    if (!fs.existsSync(jsxBuildPath)) {
        fs.mkdirSync(jsxBuildPath);
        fs.writeFile(jsxBuildPath + '/Index.jsx', jsxContent(data), 'utf8', function (err) {
            if (err) {
                return console.log('jsx:' + err);
            }
        });
    }


});