
'use strict';
import { PropTypes } from 'react';
import { NativeModules, requireNativeComponent, View } from 'react-native';

var iface = {
  name: 'Spot4BooksMap',
  propTypes: {
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
    ...View.propTypes
  },
};
var spot4BooksMap = requireNativeComponent('Spot4BooksMap', iface);

export default spot4BooksMap;