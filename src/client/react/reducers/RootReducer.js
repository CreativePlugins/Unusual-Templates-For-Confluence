import {combineReducers} from 'redux'

export const rootReducer = combineReducers({
    blank: function(state, action) {if (state == null) state = []; return state;}
});