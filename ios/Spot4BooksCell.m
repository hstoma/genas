//
//  Spot4BooksCell.m
//  genas
//
//  Created by Henadzi Stoma on 11/3/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksCell.h"


@implementation Spot4BooksCell
- (id)initWithFrame:(CGRect)frame
{
  self = [super initWithFrame:frame];
  if (self) {
    
    
    UIView* rootView = [[UIView alloc] initWithFrame:CGRectZero];
    [rootView setBackgroundColor:[UIColor blueColor]];
    [self.contentView addSubview:rootView];
    [self setBackgroundColor:[UIColor blueColor]];
    
  }
  
  return self;
  
}

@end
