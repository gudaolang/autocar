export const mapStateToProps = (state,ownProps) => {
    return {
        todos:getVisibleTodos(state.todos,ownProps.filter)
    }
}