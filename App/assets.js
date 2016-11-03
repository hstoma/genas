import { Platform } from 'react-native'

const isAndroid = Platform.OS === 'android'

const assets = {
  jsons: {
    mapstyle: require('assets/mapstyle/mapstyle.json'),
  },
}

module.exports = assets
