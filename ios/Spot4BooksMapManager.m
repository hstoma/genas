//
//  Spot4BooksMapManager.m
//  genas
//
//  Created by Henadzi Stoma on 10/25/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksMapManager.h"


@implementation Spot4BooksMapManager

RCT_EXPORT_MODULE();

- (UIView *)view {
  Spot4BooksMap *map = [Spot4BooksMap new];
  map.myLocationEnabled = NO;
  map.delegate = self;
  self.mapObject = map;
  return map;
}

#pragma mark - GMSMapViewDelegate
- (BOOL)mapView:(GMSMapView *)mapView didTapMarker:(nonnull GMSMarker *)marker {
  NSString* markerID = [self.mapObject getMarkerId:marker];
  [self.bridge.eventDispatcher sendInputEventWithName:@"onMarkerTouched" body:@{@"target":mapView.reactTag, @"markerId": markerID}];
  return TRUE;
}

RCT_EXPORT_VIEW_PROPERTY(customMapStyle, NSString)
RCT_EXPORT_VIEW_PROPERTY(centerAndZoom, NSDictionary)


- (NSArray *) customDirectEventTypes {
  return @[@"onMarkerTouched"];
}
@end
