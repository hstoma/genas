/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Dimensions
} from 'react-native';
import SimpleLabelView from './simplelabelview';
import Spot4BookMarker from './spot4bookmarker'
import Spot4BookMap from './spot4bookmap';


var point = {latitude : 65.9667,longitude : -18.5333,zoom : 7};
var markerPoint = {latitude : 65.9667,longitude : -18.5333, imageName : "icon"};

export default class genas extends Component {
  
   render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome GenaS!
        </Text>
        <SimpleLabelView style={styles.simplelabel} labelText = "Hello GenaS Again from native"></SimpleLabelView>
        <Spot4BookMap style={styles.mapStyle} centerAndZoom={point}>
          {this._renderMarkers()}
        </Spot4BookMap>
      </View>
    );
  }
 
  _renderMarkers() {
    let result = [];
	result.push( <Spot4BookMarker key={'4'} positionAndImageName={markerPoint}/> );
	return result;
  }
  
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'flex-start',
	alignItems: 'flex-start',
	flexDirection: 'column',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  simplelabel: {
    height: 20,
    width: Dimensions.get('window').width - 2 * 20,
    backgroundColor: '#F5FCFF',
  },
  mapStyle: {
    height: Dimensions.get('window').height - 40,
    width: Dimensions.get('window').width,
    
  },
});

