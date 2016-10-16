/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react'
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native'

import ReadTexts from './ReadTexts'

class App extends Component {

  constructor(props) {
    super(props)
    this.state = {
      text: 'Hello World'
    }
    ReadTexts.getTextMessages(() => {
      console.log('error')
    },
    (sms) => {
      this.setState({text: sms})
    })
  }
  render() {
    return (
      <View style={styles.container}>
        <Text>
          {this.state.text}
        </Text>
      </View>
    );
  }
  
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  }
});

module.exports = App
