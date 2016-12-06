/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react'
import {
  StyleSheet,
  Text,
  View
} from 'react-native'

import ReadTexts from './ReadTexts'

class App extends Component {

  constructor (props) {
    super(props)
    this.state = {
      sms: [],
      smsCount: 0
    }
    ReadTexts.getTextMessages(() => {
      console.log('error')
    },
    (sms) => {
      this.setState({sms: sms, smsCount: sms.length})
      console.log(this.state.sms)
    })
  }
  render () {
    return (
      <View style={styles.container}>
        <Text>
          Hello! There is {this.state.smsCount} texts
        </Text>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF'
  }
})

module.exports = App
