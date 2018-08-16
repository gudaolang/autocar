export const ADD_TODO = 'ADD_TODO'
export const TOGGLE_TODO = 'TOGGLE_TODO'
export const COMPLETED_TODO = 'COMPLETED_TODO'
export const SET_VISIBILITY_FILTER = 'SET_VISIBILITY_FILTER'

export const visilibityFilters = {
    SHOW_ALL: 'SHOW_ALL',
    SHOW_COMPLETED: 'SHOW_COMPLETED',
    SHOW_ACTIVE: 'SHOW_ACTIVE'
}

export function addTodo(text) {
    return {type: ADD_TODO, text}
}

export function toggleTodo(index) {
    return {type: TOGGLE_TODO, index}
}

export function completeTodo(index) {
    return {type: COMPLETED_TODO, index}
}

export function setVisibilityFilter(filter) {
    return {type: SET_VISIBILITY_FILTER, filter}
}