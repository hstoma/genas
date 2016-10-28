//
//  Spot4BooksCircleManager.m
//  genas
//
//  Created by Henadzi Stoma on 10/28/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksCircleManager.h"
#import "Spot4BooksCircle.h"

@implementation Spot4BooksCircleManager
RCT_EXPORT_MODULE()
- (UIView *)view
{
  Spot4BooksCircle *circle = [Spot4BooksCircle new];
  return circle;
}
RCT_EXPORT_VIEW_PROPERTY(identifier, NSString)
RCT_EXPORT_VIEW_PROPERTY(positionAndRadius, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(fillColor, UIColor)
RCT_EXPORT_VIEW_PROPERTY(strokeColor, UIColor)
@end
