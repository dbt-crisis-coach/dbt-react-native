/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react'
import {
  StyleSheet,
  Text,
  View,
  Button,
  Image
} from 'react-native'

import ReadTexts from './ReadTexts'

import Logo from './assets/AskRuru.png'

class App extends Component {

  // constructor (props) {
    // super(props)
    // this.state = {
    //   sms: [],
    //   smsCount: 0
    // }
    // ReadTexts.getTextMessages(() => {
    //   console.log('error')
    // },
    // (sms) => {
    //   this.setState({sms: sms, smsCount: sms.length})
    //   console.log(this.state.sms)
    // })
  // }

  pickContact () {
    console.log('Pick a contact has been pressed')
  }

  render () {
    return (
      <View style={styles.container}>
        {/* <Text>
          Hello! There is {this.state.smsCount} texts
        </Text> */}
        <Image
          source={Logo}
          style={{width: 100, height: 100}}
        />
        <Button
          onPress={this.pickContact}
          title='Select Contact'
        />
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#fff'
  }
})

module.exports = App
