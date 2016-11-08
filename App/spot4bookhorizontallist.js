
'use strict';
import React, { PropTypes } from 'react';
import { NativeModules, requireNativeComponent, View } from 'react-native';
import Immutable from 'immutable';
import * as Settings from './settings';

class Spot4BooksHorizontalListView extends React.Component{
  constructor () {
      super();
  } 
}
Spot4BooksHorizontalListView.propTypes = {
     bookList: React.PropTypes.array,
     ...View.propTypes
}  
var spot4BooksHorizontalList = requireNativeComponent('Spot4BooksHorizontalListView', Spot4BooksHorizontalListView);

export default spot4BooksHorizontalList;