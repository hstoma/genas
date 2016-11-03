//
//  SimpleItemObject.m
//  genas
//
//  Created by Henadzi Stoma on 11/3/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "SimpleItemObject.h"

@implementation SimpleItemObject
- (instancetype)initWithProperties:(NSString*) labelText withWidth:(float) width andHeight:(float) height{
  self = [super init];
  if (self) {
    self.labelText = labelText;
    self.width = width;
    self.height = height;
  }
  return self;
}
@end
