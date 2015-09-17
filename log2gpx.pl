#!/usr/bin/perl
use strict;

use Storbale;

my $bssid_cache = {};
my $cacheFile = '/tmp/bssidCache';
$| = 1;

if (-f $cache) {
  $bssid_cache = retrieve($cacheFile);
}

while (<>) {
  chomp;
  my ($time, $log) = split(/\t/, $_);
  my ($ts, $ymd, $his, $cst, $loc) = split(/ /, $time);
  my ($label, $bssid, $signal, $ssid) = split(/ /, $log);
}

sub bssidLookup {
  my ($bssid) = @_;

  return $bssid_cache->{$bssid} if($bssid_cache->{$bssid});

  my $latlon = getLatLonByBssid($bssid);
  $bssid_cache->{$bssid} = $latlon if ($latlon);

  return $latlon;
}

sub getLatLonByBssid {
  my ($bssid) = @_;
}
