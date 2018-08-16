import React,{Component} from 'react'
import PropTypes from  'prop-types'
import {FilterLink} from  './container/FilterLink.jsx'
import {Link} from 'react-router'

export default class TodoFoot extends Component {
    renderFilter(filter, name) {
        if (filter === this.props.filter) {
            return name
        }
        return (
            <a href='#' onClick={e=>{
            e.preventDefault()
            this.props.onFilterChange(filter)
            }}>
                {name}
            </a>
        )
    }

    render() {
        return (
            <p>
                显示:{' '}
                <FilterLink filter="all">所有</FilterLink>
                {', '}
                <FilterLink filter="completed">已完成</FilterLink>
                {', '}
                <FilterLink filter="completed">未完成</FilterLink>
                /*显示:{' '}
                {this.renderFilter('SHOW_ALL', '所有')}
                {', '}
                {this.renderFilter('SHOW_COMPLETED', '已完成')}
                {', '}
                {this.renderFilter('SHOW_ACTIVE', '未完成')}*/
            </p>
        )
    }
}

TodoFoot.propTypes = {
    onFilterChange: PropTypes.func.isRequired,
    filter: PropTypes.oneOf([
        'SHOW_ALL', 'SHOW_COMPLETED', 'SHOW_ACTIVE'
    ]).isRequired
}