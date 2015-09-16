ssidLogger
==========

<img src="https://rawgit.com/zordius/ssidLogger/master/logo.svg" align="right"> SSID logger - an Android app for position tracking, target to logging without GPS/network access and low battery usage

**Features**

* SSID logging
 * low battery usage
 * no network required
 * logging scanned Wi-Fi SSID/BSSID and timestamp
* File conversion
 * use xxxx API to resolve SSID/BSSID location (todo)
 * convert SSID/BSSID to gpx/kml files (todo)
* Major UI
 * no tabs / dropdown / menu , one page
 * change log file position
 * add comment in log
 * file conversion (todo)
 * start/stop recording (DONE)

THE APP IS NOT READY
====================

some API reference.... (should pick 1 free/unlimited solution)
* http://www.openbmap.org/api/openbmap_api.php5
* http://orwelliantremors.blogspot.tw/2010/12/mobile-80211-parole-bracelet-for-man-in.html
* http://coderrr.wordpress.com/2008/09/10/get-the-physical-location-of-wireless-router-from-its-mac-address-bssid/
* https://developers.google.com/maps/documentation/business/geolocation/
* this works: https://maps.googleapis.com/maps/api/browserlocation/json?browser=firefox&sensor=true&wifi=mac:78:cd:8e:a6:f4:c9|ss:-82
  * ref: https://milo2012.wordpress.com/2012/02/23/geolocation-via-wireless-access-points/
* https://wigle.net/search
  * this limited 50 query per day and require account
