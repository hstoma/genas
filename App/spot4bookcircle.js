
'use strict';
import { PropTypes } from 'react';
import { NativeModules, requireNativeComponent, View } from 'react-native';

var iface = {
  name: 'Spot4BooksCircle',
  propTypes: {
    positionAndRadius:PropTypes.shape({
    /**
     * Coordinates for marker.
     */
    latitude: PropTypes.number.isRequired,
    longitude: PropTypes.number.isRequired,
    /**
     * radius.
     */
    radius: PropTypes.number.isRequired
  }),
    strokeColor: PropTypes.string.isRequired,
    fillColor: PropTypes.string.isRequired,
    ...View.propTypes
  },
};
var spot4BooksCircle = requireNativeComponent('Spot4BooksCircle', iface);

export default spot4BooksCircle;