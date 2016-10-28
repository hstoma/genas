//
//  Spot4BooksMarkerManager.m
//  genas
//
//  Created by Henadzi Stoma on 10/27/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksMarkerManager.h"
#import "Spot4BooksMarker.h"

@implementation Spot4BooksMarkerManager
RCT_EXPORT_MODULE()

- (UIView *)view
{
  Spot4BooksMarker *marker = [Spot4BooksMarker new];
  return marker;
}

RCT_EXPORT_VIEW_PROPERTY(identifier, NSString)
RCT_EXPORT_VIEW_PROPERTY(positionAndImageName, NSDictionary)


@end
