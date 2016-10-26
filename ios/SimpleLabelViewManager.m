//
//  SimpleLabelViewManager.m
//  genas
//
//  Created by Henadzi Stoma on 10/25/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "SimpleLabelViewManager.h"
#import "SimpleLabelView.h"

@implementation SimpleLabelViewManager

RCT_EXPORT_MODULE();

- (UIView *)view { return [[SimpleLabelView alloc] init]; }

RCT_EXPORT_VIEW_PROPERTY(labelText, NSString);

@end
