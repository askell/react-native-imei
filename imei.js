/**
 * @providesModule react-native-imei
 */

import { Platform, NativeModules } from 'react-native';

export default {
  getImei() {
    if (Platform.OS === "android") {
      return NativeModules.IMEI.getImei();
    } else {
      throw new Error("Not implemented");
    }
  }
};
