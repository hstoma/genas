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
  return map;
}

#pragma mark - GMSMapViewDelegate
- (BOOL)mapView:(GMSMapView *)mapView didTapMarker:(nonnull GMSMarker *)marker {
  [self.bridge.eventDispatcher sendInputEventWithName:@"onMarkerTouched" body:@{@"target":mapView.reactTag, @"markerId": @"5"}];
  return TRUE;
}

RCT_EXPORT_VIEW_PROPERTY(centerAndZoom, NSDictionary)

- (NSArray *) customDirectEventTypes {
  return @[@"onMarkerTouched"];
}
@end
