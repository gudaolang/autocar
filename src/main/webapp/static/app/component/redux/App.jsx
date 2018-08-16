import React,{Component} from 'react'
import {connect} from 'react-redux'
import PropTypes from  'prop-types'
import {addTodo,completeTodo,setVisibilityFilter,visilibityFilters} from './actions.jsx'
import AddTodo from './todo/container/AddTodo'
import TodoList from './todo/TodoList'
import TodoFoot from './todo/TodoFoot'

class App extends React.Component {

    render() {
        const {dispatch,visibleTodos,visibilityFilter} = this.props
        return (
            <div className="cont">
                <div className="index">
                    <AddTodo onAddClick={text=>dispatch(addTodo(text))}/>
                    <TodoList
                        todos={visibleTodos}
                        onTodoClick={index=>dispatch(completeTodo(index))}
                    />
                    <TodoFoot
                        filter={visibilityFilter}
                        onFilterChange={nextFilter => dispatch(setVisibilityFilter(nextFilter))}
                    />
                </div>
            </div>
        );
    }
}

App.propTypes = {
    visibleTodos: PropTypes.arrayOf(PropTypes.shape({
        text: PropTypes.string.isRequired,
        completed: PropTypes.bool.isRequired
    }).isRequired).isRequired,
    visibilityFilter: PropTypes.oneOf([
        'SHOW_ALL', 'SHOW_COMPLETED', 'SHOW_ACTIVE'
    ]).isRequired
}

function selectTodos(todos, filter) {
    switch (filter) {
        case visilibityFilters.SHOW_ALL:
            return todos;
        case visilibityFilters.SHOW_COMPLETED:
            return todos.filter(todo=>todo.completed)
        case visilibityFilters.SHOW_ACTIVE:
            return todos.filter(todo=>!todo.completed)
    }
}

function select(state) {
    return {
        visibleTodos: selectTodos(state.todos, state.visibilityFilter),
        visibilityFilter: state.visibilityFilter
    }
}

export default connect(select)(App)