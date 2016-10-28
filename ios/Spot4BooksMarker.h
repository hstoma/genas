//
//  Spot4BooksMarker.h
//  genas
//
//  Created by Henadzi Stoma on 10/27/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <GoogleMaps/GoogleMaps.h>
#import "RCTBridge.h"
#import "RCTComponent.h"

@interface Spot4BooksMarker : UIView

@property (nonatomic, assign) NSString *identifier;
@property (nonatomic, assign) CLLocationCoordinate2D coordinate;
@property (nonatomic, assign) NSString* imageName;
@property (nonatomic, strong) GMSMarker* realMarker;


- (void)setPositionAndImageName:(NSDictionary *) positionAndImageName;
- (void)setIdentifier:(NSString *) identifierValue;
@end
