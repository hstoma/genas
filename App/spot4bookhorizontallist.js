
'use strict';
import { PropTypes } from 'react';
import { NativeModules, requireNativeComponent, View } from 'react-native';

var iface = {
  name: 'Spot4BooksHorizontalList',
  propTypes: {
     ...View.propTypes
  },
};
var spot4BooksHorizontalList = requireNativeComponent('Spot4BooksHorizontalListView', iface);

export default spot4BooksHorizontalList;