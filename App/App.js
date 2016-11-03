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
import Spot4BooksHorizontalList from './spot4bookhorizontallist';

export default class genas extends Component {
  
   render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome GenaS!
        </Text>
        <SimpleLabelView style={styles.simplelabel} labelText = "Hello GenaS Again from native"></SimpleLabelView>
        <Spot4BooksHorizontalList style={styles.listStyle} />
      </View>
    );
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
  listStyle: {
    height: Dimensions.get('window').height - 40 - Dimensions.get('window').height/2,
    width: Dimensions.get('window').width,
    backgroundColor: '#F5FCFF',
  },
  mapStyle: {
    height: Dimensions.get('window').height - 40,
    width: Dimensions.get('window').width,
    
  },
});

