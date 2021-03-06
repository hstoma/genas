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
  ScrollView,
  Dimensions
} from 'react-native';
import SimpleLabelView from './simplelabelview';
import Spot4BooksHorizontalList from './spot4bookhorizontallist';
function Book (url, title) {
    this.url = url;
    this.title = title;
}



const books = new Array(new Book('https://spot4books.imgix.net/images/bookcovers/9789038893846.jpg', 'Huid en haar'), 
                        new Book('https://spot4books.imgix.net/images/bookcovers/9789038899893.jpg','Het bestand'),
                        new Book('https://spot4books.imgix.net/images/bookcovers/9789021442785.jpg','Ge sta mel de werken'),
                        new Book('https://spot4books.imgix.net/images/bookcovers/9789021438627.jpg','De Nederlandse maagd'),
                        new Book('https://spot4books.imgix.net/images/bookcovers/9789021400747.jpg','De Amerikaanse prinses'),
                        new Book('https://spot4books.imgix.net/images/bookcovers/9789021438627.jpg','De Nederlandse maagd'),
                        new Book('https://spot4books.imgix.net/images/bookcovers/9789044534610.jpg','Witte raaf'),
                        new Book('https://spot4books.imgix.net/images/bookcovers/9789021456164.jpg','Het verlangen van de egel'),
                        new Book('https://spot4books.imgix.net/images/bookcovers/9789029539401.jpg','De man van vroeger'),
                        new Book('https://spot4books.imgix.net/images/bookcovers/9789021436081.jpg','Verzamel de liefde'),
                        new Book('https://spot4books.imgix.net/images/bookcovers/9789021457819.jpg','Een schitterend isolement'),
                        new Book('https://spot4books.imgix.net/images/bookcovers/9789021442037.jpg','Mijn meneer'),
                       );
export default class genas extends Component {
   render() {
    console.log('-----------OK');
    return (
      <ScrollView
          scrollEventThrottle={ 16 }
          showsVerticalScrollIndicator={ false }>
      
        <Spot4BooksHorizontalList key='1' style={styles.listStyle} bookList={books} onItemTouched={(e) => this._itemSelected(e)}/>
        
        <Spot4BooksHorizontalList key='2' style={styles.listStyle} bookList={books} onItemTouched={(e) => this._itemSelected(e)}/>
        
        <Spot4BooksHorizontalList key='3' style={styles.listStyle} bookList={books} onItemTouched={(e) => this._itemSelected(e)}/>
      
        </ScrollView>
    );
  }

_itemSelected(e) {
    console.log('----OK------=====');
    console.log('----' + e.nativeEvent.itemId);
    alert(e.nativeEvent.itemId);
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
    height: 240,
    width: Dimensions.get('window').width,
    backgroundColor: '#F5FCFF',
    marginTop: 25
  },
  mapStyle: {
    height: Dimensions.get('window').height - 40,
    width: Dimensions.get('window').width,
    
  },
});

