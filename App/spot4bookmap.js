
'use strict';
import React, { PropTypes } from 'react';
import { NativeModules, requireNativeComponent, View, NativeEventEmitter } from 'react-native';

const Spot4BooksMapObject = requireNativeComponent('Spot4BooksMap', Spot4BooksMap);

class Spot4BooksMap extends React.Component{
  constructor () {
      super();
    
       
      //this.onMapReady = this.onMapReady.bind(this);
      /*if (Platform.OS === 'ios') {
        this.onMapReady();
      }*/
    
  
  }
   
  render() {
    const {style, centerAndZoom, mapReady} = this.props;
    return (
        <Spot4BooksMapObject
           onMapReady={(event) => mapReady(event)}
          />);
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
    mapReady: React.PropTypes.func,
    ...View.propTypes,
};

var spot4BooksMap = requireNativeComponent('Spot4BooksMap', Spot4BooksMap);

export default spot4BooksMap;