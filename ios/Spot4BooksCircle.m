//
//  Spot4BooksCircle.m
//  genas
//
//  Created by Henadzi Stoma on 10/28/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksCircle.h"

@implementation Spot4BooksCircle

- (void)setPositionAndRadius:(NSDictionary *) positionAndRadius {
  if (positionAndRadius!=NULL) {
    CLLocationDegrees lat = [[positionAndRadius objectForKey:@"latitude"] doubleValue];
    CLLocationDegrees lon = [[positionAndRadius objectForKey:@"longitude"] doubleValue];
    self.coordinate = CLLocationCoordinate2DMake(lat,lon);
    self.radius = [[positionAndRadius objectForKey:@"radius"] doubleValue];;
  }
}
@end
