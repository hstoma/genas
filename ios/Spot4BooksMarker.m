//
//  Spot4BooksMarker.m
//  genas
//
//  Created by Henadzi Stoma on 10/27/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksMarker.h"

@implementation Spot4BooksMarker



- (void)setPositionAndImageName:(NSDictionary *) positionAndImageName {
  if (positionAndImageName!=NULL) {
    CLLocationDegrees lat = [[positionAndImageName objectForKey:@"latitude"] doubleValue];
    CLLocationDegrees lon = [[positionAndImageName objectForKey:@"longitude"] doubleValue];
    self.coordinate = CLLocationCoordinate2DMake(lat,lon);
    self.imageName = [positionAndImageName objectForKey:@"imageName"];
  }
}

@end
