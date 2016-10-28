//
//  Spot4BooksMapManager.m
//  genas
//
//  Created by Henadzi Stoma on 10/25/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksMapManager.h"


@interface Spot4BooksMapManager() <GMSMapViewDelegate>

@end

@implementation Spot4BooksMapManager

RCT_EXPORT_MODULE();

- (UIView *)view {
  Spot4BooksMap *map = [Spot4BooksMap new];
  map.delegate = self;
  return map;
}

RCT_EXPORT_VIEW_PROPERTY(centerAndZoom, NSDictionary)

@end
