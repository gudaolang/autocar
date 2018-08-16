import React from 'react'
import Link from './Link.jsx'
import {connect} from 'react-redux'
import {setVisibilityFilter} from '../../actions'
const mapStateToProps = (state, ownProps) => {
    return {
        active: ownProps.filter === state.visibilityFilter
    }
}

const mapDispatcherToProps = (dispatch, ownProps) => {
    return {
        onClick: ()=> {
            dispatch(setVisibilityFilter(ownProps.filter));
        }
    }
};

const FilterLink = connect(mapStateToProps, mapDispatcherToProps)(Link)

export default FilterLink




