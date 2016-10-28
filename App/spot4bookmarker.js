
'use strict';
import { PropTypes } from 'react';
import { NativeModules, requireNativeComponent, View } from 'react-native';

var iface = {
  name: 'Spot4BooksMarker',
  propTypes: {
    positionAndImageName:PropTypes.shape({
    /**
     * Coordinates for marker.
     */
    latitude: PropTypes.number.isRequired,
    longitude: PropTypes.number.isRequired,
    /**
     * image name.
     */
    imageName: PropTypes.string.isRequired
  }),
    identifier: PropTypes.string.isRequired, 
    ...View.propTypes
  },
};
var spot4BooksMapMarker = requireNativeComponent('Spot4BooksMarker', iface);

export default spot4BooksMapMarker;