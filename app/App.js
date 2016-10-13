/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react'
import {
  AppRegistry,
  Text,
  View
} from 'react-native'

import ReadTexts from './ReadTexts'

class AskRuru extends Component {

  constructor(props) {
    super(props)
    ReadTexts.getTextMessages()
  }
  render() {
    return (
      <View>
        <Text>
          Welcome to React Native!
        </Text>
      </View>
    );
  }
}

AppRegistry.registerComponent('AskRuru', () => AskRuru);
