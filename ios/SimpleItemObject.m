//
//  SimpleItemObject.m
//  genas
//
//  Created by Henadzi Stoma on 11/3/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "SimpleItemObject.h"

@implementation SimpleItemObject
- (instancetype)initWithProperties:(NSString*) labelText withUrl:(NSString*) url;{
  self = [super init];
  if (self) {
    NSLog(@"-------LABEL-------%@", labelText);
    self.labelText = labelText;
    NSLog(@"-------URL-------%@", url);
    self.urlText = url;
  }
  return self;
}
@end
