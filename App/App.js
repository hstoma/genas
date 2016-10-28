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
import Spot4BooksMarker from './spot4bookmarker'
import Spot4BooksCircle from './spot4bookcircle'
import Spot4BooksMap from './spot4bookmap';


var point = {latitude : 65.9667,longitude : -18.5333,zoom : 15};
var markerPoint = {latitude : 65.9667,longitude : -18.5333, imageName : 'marker'};
var circlePoint = {latitude : 65.9667,longitude : -18.5333, radius: 115.0};
var markerPoint1 = {latitude : 65.9650,longitude : -18.5327, imageName : 'marker'};
var markerPoint2 = {latitude : 65.9654,longitude : -18.5330, imageName : 'marker'};
var markerPoint3 = {latitude : 65.9645,longitude : -18.5330, imageName : 'marker'};
var circlePoint1 = {latitude : 65.9640,longitude : -18.5320, radius: 115.0};


export default class genas extends Component {
  
   render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome GenaS!
        </Text>
        <SimpleLabelView style={styles.simplelabel} labelText = "Hello GenaS Again from native"></SimpleLabelView>
        <Spot4BooksMap style={styles.mapStyle} centerAndZoom={point} 
          onMapReady={(e) => console.log('------OK----READY')}  
          onMarkerTouched={(e) => this._markerSelected(e)}>
          {this._renderMarkers()} 
          {this._renderCircles()}
        </Spot4BooksMap>
      </View>
    );
  }
 
  _markerSelected(e) {
    console.log('----' + e.nativeEvent.markerId);
    alert(e.nativeEvent.markerId);
  }
  
  _renderMarkers() {
    let result = [];
	result.push( <Spot4BooksMarker identifier='1' key={'1'} positionAndImageName={markerPoint}/> );
    result.push( <Spot4BooksMarker identifier='2' key={'2'} positionAndImageName={markerPoint1}/> );
    result.push( <Spot4BooksMarker identifier='3' key={'3'} positionAndImageName={markerPoint2}/> );
    result.push( <Spot4BooksMarker identifier='4' key={'4'} positionAndImageName={markerPoint3}/> );
	return result;
  }
  _renderCircles() {
    let result = [];
	result.push( <Spot4BooksCircle identifier='10' key={'10'} positionAndRadius={circlePoint} fillColor = 'rgba(0,228,255,0.25)'	strokeColor = 'rgb(255,255,255)'/> );
    result.push( <Spot4BooksCircle identifier='11' key={'11'} positionAndRadius={circlePoint1} fillColor = 'rgba(0,228,255,0.25)'	strokeColor = 'rgb(255,255,255)'/> );
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

