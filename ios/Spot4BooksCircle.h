//
//  Spot4BooksCircle.h
//  genas
//
//  Created by Henadzi Stoma on 10/28/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <GoogleMaps/GoogleMaps.h>
#import "RCTBridge.h"
#import "RCTComponent.h"

@interface Spot4BooksCircle : UIView
@property (nonatomic, assign) NSString *identifier;
@property (nonatomic, assign) CLLocationCoordinate2D coordinate;
@property (nonatomic, assign) CLLocationDistance radius;
@property (nonatomic, strong) GMSCircle* realCircle;
@property (nonatomic, strong) UIColor *fillColor;
@property (nonatomic, strong) UIColor *strokeColor;


- (void)setPositionAndRadius:(NSDictionary *) positionAndRadius;

@end
