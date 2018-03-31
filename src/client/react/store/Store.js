import { createStore, applyMiddleware, compose } from 'redux'
import thunkMiddleware from 'redux-thunk'
import createLogger from 'redux-logger'
import { rootReducer } from '../reducers/RootReducer'

export default function initStore() {
    return compose(
        applyMiddleware(thunkMiddleware),
        applyMiddleware(createLogger())
    )(createStore)(rootReducer)
}