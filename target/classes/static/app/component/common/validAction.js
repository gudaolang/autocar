//验证 redux action

import {isPlainObject,isString} from 'lodash'

export function isError(action) {
    return isFSA(action) && action.error === true;
}


export function isFSA(action) {
    return (isPlainObject(action) && isString(action.type) && Object.keys(action).every(isValidKey))
}

export function isValidKey(key) {
    return ['type', 'payload', 'error', 'meta'].indexOf(key) > -1;
}



