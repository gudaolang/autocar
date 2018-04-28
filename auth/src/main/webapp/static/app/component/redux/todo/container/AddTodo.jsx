import React,{Component} from 'React'
import PropTypes from  'prop-types'

import {Button,Input} from 'material-ui';

export default class AddTodo extends Component {

    render() {
        return (
            <div>
                <Input onKeyUp={e => this.getVal(e)}/>
                <Button variant="raised" color="default" onClick={e => this.handleClick(e)}>添加事项</Button>
            </div>
        )
    }

    getVal(e) {
        this.textInput = e.target.value;
    }

    handleClick(e) {
        const text = this.textInput;
        console.log('options:'+this.props);
        if (Boolean(text) && text.length > 0) {
            this.props.onAddClick(text)
        }
    }
}

AddTodo.propTypes = {
    onAddClick: PropTypes.func.isRequired
}