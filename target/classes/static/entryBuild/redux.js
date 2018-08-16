import React from 'react';
import ReactDOM from 'react-dom';
import Index from '../app/component/redux/Index.jsx';
import Header from '../app/component/common/head.jsx';
import Footer from '../app/component/common/foot.jsx';
ReactDOM.render([<Header key="Header"/>,<Index key="Index"/>,<Footer key="Footer"/>],document.getElementById('app'));