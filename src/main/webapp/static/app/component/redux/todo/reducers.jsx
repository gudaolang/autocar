import {combineReducers} from 'redux'
import {Dialog} from 'material-ui'
import {ADD_TODO,COMPLETED_TODO,SET_VISIBILITY_FILTER,visilibityFilters} from '../actions.jsx'

function visibilityFilter(state = visilibityFilters.SHOW_ALL, action) {
    switch (action.type) {
        case SET_VISIBILITY_FILTER:
            return action.filter;
        default:
            return state
    }
}

function todos(state = [], action) {

    switch (action.type) {
        case ADD_TODO:
            return [
                ...state,
                {
                    text: action.text,
                    completed: false
                }
            ];
        case COMPLETED_TODO:
            return [
                ...state.slice(0, action.index),
                Object.assign({}, state[action.index], {completed: true}),
                ...state.slice(action.index + 1)
            ];
        default:
            return state
    }
}

const todoApp = combineReducers({
    visibilityFilter, todos
});
export default todoApp