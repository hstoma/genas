
'use strict';
import { PropTypes } from 'react';
import { NativeModules, requireNativeComponent, View } from 'react-native';

var iface = {
  name: 'SimpleLabelView',
  propTypes: {
    labelText: PropTypes.string,
    ...View.propTypes
  },
};
var simpleLabelView = requireNativeComponent('SimpleLabelView', iface);

export default simpleLabelView;