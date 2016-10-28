
'use strict';
import React, { PropTypes } from 'react';
import { NativeModules, requireNativeComponent, View, NativeEventEmitter } from 'react-native';

const Spot4BooksMapObject = requireNativeComponent('Spot4BooksMap', Spot4BooksMap);

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
    onMapReady: React.PropTypes.func,
    ...View.propTypes,
};
var spot4BooksMap = requireNativeComponent('Spot4BooksMap', Spot4BooksMap);

export default spot4BooksMap;