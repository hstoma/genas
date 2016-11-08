import { NativeModules } from 'react-native';

const PREFIX = 'SETTINGS_'
export const SET_LOCATION_SERVICES = PREFIX + 'SET_LOCATION_SERVICES'

export function setLocationServices(state) {
  console.log('-----------OK' + state);
  return {
    type: SET_LOCATION_SERVICES,
    state,
  }
}

export function updateLocationServices() {
  return (dispatch, getState) => {
    NativeModules.SystemManager.getLocationServicesState()
      .then(state => {
        dispatch(setLocationServices(state))
      })
  }
}
