//
//  Spot4BooksMap.h
//  genas
//
//  Created by Henadzi Stoma on 10/25/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <GoogleMaps/GoogleMaps.h>
#import "RCTComponent.h"
#import "Spot4BooksMarker.h"


@interface Spot4BooksMap : GMSMapView


- (void) setCenterAndZoom:(NSDictionary *) centerAndZoom;

@end
