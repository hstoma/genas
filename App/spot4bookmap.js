
'use strict';
import React, { PropTypes } from 'react';
import { NativeModules, requireNativeComponent, View, NativeEventEmitter } from 'react-native';
import assets from './assets';
const Spot4BooksMapObject = requireNativeComponent('Spot4BooksMap', Spot4BooksMap);
const mapStyleJsonString = JSON.stringify(assets.jsons.mapstyle);
class Spot4BooksMap extends React.Component{
  constructor () {
      super();
  } 
}  

Spot4BooksMap.propTypes = {
    centerAndZoom:PropTypes.shape({
      /**
       * Coordinates for the center of the map.
       */
      latitude: PropTypes.number.isRequired,
      longitude: PropTypes.number.isRequired,
      /**
       * zoom.
       */
      zoom: PropTypes.number.isRequired
    }),
    customMapStyle: PropTypes.string.isRequired,
    ...View.propTypes,
};
var spot4BooksMap = requireNativeComponent('Spot4BooksMap', Spot4BooksMap);

export default spot4BooksMap;