import React,{Component} from 'react'
import {render} from 'react-dom'
import {Provider} from 'react-redux'
import {Router,Route,browserHistory} from 'react-router'
import {createStore} from 'redux'
import todoApp from './todo/reducers.jsx'
import App from './App'


import { MuiThemeProvider, createMuiTheme } from 'material-ui/styles';
import purple from 'material-ui/colors/purple';
import green from 'material-ui/colors/green';

const theme = createMuiTheme({
    palette: {
        primary: {
            light: purple[300],
            main: purple[500],
            dark: purple[700]
        },
        secondary: {
            light: green[300],
            main: green[500],
            dark: green[700]
        },
    },
});

class Index extends Component {

    render() {
        let store = createStore(todoApp)

        return (
            <MuiThemeProvider theme={theme}>
                <Provider store={store}>
                    <Router history={browserHistory}>
                        <Route path="/(:filter)" component="{App}"/>
                    </Router>
                </Provider>
            </MuiThemeProvider>
        )
    }
}
export default Index;